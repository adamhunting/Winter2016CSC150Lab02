package com.ahunting.Lab02;

/**
 * Created by Adam on 1/14/2016.
 */
public class GameManager {

    private SoundManager sm;
    private GameEngine ge;
    private Logger logger;

    public boolean Init(Logger logger)
    {
        this.logger = logger;
         this.sm = new SoundManager();
        if(sm.Init(logger))
        {
            logger.Log(LogLevelEnum.Info, "Sound Manager Has Init");
            this.ge = new GameEngine();
            if(ge.Init(logger))
            {
                logger.Log(LogLevelEnum.Info, "Game Engine Has Init");
                logger.Log(LogLevelEnum.Info,"Game Manager Has Init");
                return true;
            }
            else
            {
                logger.Log(LogLevelEnum.Fatal,"Game Engine did not Init");
                sm.Shutdown();
                return false;
            }
        }
        else
        {
            logger.Log(LogLevelEnum.Fatal,"Sound Manager did not Init");
            return false;
        }

    }
    public void Play()
    {
        int num = (int)(Math.random() * 8)+2;
        for (int i = 0; i < num; ++i)
        {
            logger.Log(LogLevelEnum.Performance,"*************%d***************", i);
            sm.PlaySound();
            ge.Draw();
        }
    }

    public void Shutdown()
    {
        ge.Shutdown();
        sm.Shutdown();
        logger.Log(LogLevelEnum.Info,"Game Manager Has ShutDown");
    }
}
