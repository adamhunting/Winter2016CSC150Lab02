package com.ahunting.Lab02;


public class Main {


    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.Init();
        logger.Log("Begin main()");
        for (int i = 0; i < 5; ++i) {
            logger.Log(LogLevelEnum.Performance,"*************%d***************", i);

            try {
                throw new Exception("I've been better!");
            } catch (Exception ex) {
                logger.Log(LogLevelEnum.Error, "I had an error msg:[%s]", ex.toString());
            }



            int num = args.length;

            logger.Log(LogLevelEnum.Debug, "There were %d command line args", num);

            for (int j = 0; j < num; ++j) {

                logger.Log(LogLevelEnum.Debug, "args[%d] = [%s]", j, args[j]);

            }
        }

        logger.Log("End Main()");
        logger.ShutDown();
    }
}
I