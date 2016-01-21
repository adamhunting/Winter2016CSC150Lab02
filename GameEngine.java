package com.ahunting.Lab02;

import java.io.IOException;

/**
 * Created by Adam on 1/14/2016.
 */
public class GameEngine
{

    private Logger logger;

    public boolean Init(Logger logger)
    {
        int num = (int)(Math.random() *10);
        if(num != 0)
        {
            this.logger = logger;
            return true;
        }
        else
        {
           return false;
        }
    }

    public void Draw()
    {
        int num = (int)(Math.random() * 3)+ 1;
        try {
            switch (num)
            {
                case (1):
                {
                    logger.Log(LogLevelEnum.Info, "Game Engine Drawn: A One");
                }
                break;

                case (2):
                {
                    throw new IOException("FileNotFoundException");
                }

                case (3):
                {
                    logger.Log(LogLevelEnum.Info, "Game Engine Drawn: A Three");
                }
                break;

                default:
                {
                    System.out.print("You Gone done messed up");
                }
                break;
            }
        }
        catch (IOException FileNotFoundException)
        {
            logger.Log(LogLevelEnum.Error,"Game Engine: Draw FileNotFound");

        }

    }

    public void Shutdown()
    {
        logger.Log(LogLevelEnum.Info,"Game Engine Has Shutdown");
    }
}
