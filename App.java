package com.ahunting.Lab02;


public class App {


    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.Init("log.txt");
        logger.Log("Begin main()");
        GameManager gm = new GameManager();
            try
            {
                throw new Exception("I've been better!");
            }
            catch (Exception ex)
            {
                logger.Log(LogLevelEnum.Error, "I had an error msg:[%s]", ex.toString());
            }

            int num = args.length;
            logger.Log(LogLevelEnum.Debug, "There were %d command line args", num);

            float num2 = 12f;
            int num3 = (int)(Math.random() * 3)+ 1;
            for (int j = 0; j < num; ++j)
            {

                logger.Log(LogLevelEnum.Debug, "args[%d] = [%s]", j, args[j]);
            }

        logger.Log(LogLevelEnum.Warning,"Bobs is [%f] Years Old Your Grade is [%c] This is a String [%s] this is a random number [%d]",num2,'F',"Bobs your uncle",num3);

            if(gm.Init(logger))
            {
                gm.Play();
                gm.Shutdown();
            }
            else
            {
            logger.Log(LogLevelEnum.Fatal,"Game Manager did not Init");
            }



        logger.Log(LogLevelEnum.Info,"End App()");
        logger.ShutDown();
    }
}
