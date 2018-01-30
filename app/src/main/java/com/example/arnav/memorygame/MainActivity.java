package com.example.arnav.memorygame;
//This seems verbose, but I had to individually code each of the 12 buttons, which is why it's so long
//The onClick methods for each buttons are virtually the same, so I didn't provide information for any other
//buttons after the first one
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;
public class MainActivity extends AppCompatActivity
{
    int memoryCounter = 0; //This keeps track of whether a button is already displaying text
    Button alreadyClicked = null; //This holds the button whose text is being displayed
    int alreadyClickedId = 0; //This lets us store the ID of the button whose text is being displayed
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Helper method for the generation of random numbers in the array
    public boolean found(int[][] a, int num, int i)
    {
        if(i == 0 || i == 1) //We are searching through the first 2 rows
        {
            for(int k = 0; k < 2; k++)
            {
                for(int n = 0; n < 3; n++)
                {
                    if(a[k][n] == num)
                    {
                        return true;
                    }
                }
            }
        }

        else //We are searching the last two rows
        {
            for(int k = 2; k < 4; k++)
            {
                for(int n = 0; n < 3; n++)
                {
                    if(a[k][n] == num)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    //Generates random numbers for our main array
    public int[][] generateArray()
    {
        int[][] a = new int[4][3];
        Random r = new Random();
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                int num = r.nextInt(6);
                while(found(a, num, i))
                {
                    num = r.nextInt(6) + 1;
                }
                a[i][j] = num;
            }
        }
        return a;
    }

    int[][] a = generateArray(); //Holds the "values" of each button

    public void clickB00(View view)
    {
        if(memoryCounter == 1) //This means that a button is already displaying text
        {
            int value1 = a[0][0];
            int value2 = a[alreadyClickedId / 10][alreadyClickedId % 10]; //Letting us know the value of the text already being displayed
            if(value1 == value2)
            {
                Button b = (Button)findViewById(R.id.B00);
                b.setText(String.valueOf(value1));
                alreadyClicked.setText(String.valueOf(value2)); //We can set the text of both buttons if they are equal
            }
            else
            {
                final Button b = (Button)findViewById(R.id.B00);
                b.setText(String.valueOf(value1)); //Temporarily showing them the values of both buttons

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b.setText(""); //Setting no text on both buttons again
                        alreadyClicked.setText("");
                    }
                }, 1000);

                //This try catch block was my initial approach to making the app pause before removing the text for both buttons; it didn't work
                /*
                try
                {
                    b.setText(String.valueOf(value1));
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                alreadyClicked.setText("");
                alreadyClicked = null;
                b.setText("");
                */
            }
            memoryCounter = 0; //Two buttons have already been clicked, so we set this variable back to 0
        }
        else //This was the first button to display text
        {
            memoryCounter++; //Setting the variable to one, so that we know that a button has been pressed
            alreadyClicked = (Button)findViewById(R.id.B00); //Storing this button
            alreadyClicked.setText(String.valueOf(a[0][0])); //Displaying the value of this button
            alreadyClickedId = 00; //Used for getting our "button value" from our array
        }
    }

    public void clickB01(View view)
    {
        if(memoryCounter == 1)
        {
            int value1 = a[0][1];
            int value2 = a[alreadyClickedId / 10][alreadyClickedId % 10];
            if(value1 == value2)
            {
                Button b = (Button)findViewById(R.id.B01);
                b.setText(String.valueOf(value1));
                alreadyClicked.setText(String.valueOf(value2));
            }
            else
            {
                final Button b = (Button)findViewById(R.id.B01);
                b.setText(String.valueOf(value1));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b.setText("");
                        alreadyClicked.setText("");
                    }
                }, 1000);

                /*
                try
                {
                    b.setText(String.valueOf(value1));
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                alreadyClicked.setText("");
                alreadyClicked = null;
                b.setText("");
                */
            }
            memoryCounter = 0;
        }
        else
        {
            memoryCounter++;
            alreadyClicked = (Button)findViewById(R.id.B01);
            alreadyClicked.setText(String.valueOf(a[0][1]));
            alreadyClickedId = 01;
        }
    }

    public void clickB02(View view)
    {
        if(memoryCounter == 1)
        {
            int value1 = a[0][2];
            int value2 = a[alreadyClickedId / 10][alreadyClickedId % 10];
            if(value1 == value2)
            {
                Button b = (Button)findViewById(R.id.B02);
                b.setText(String.valueOf(value1));
                alreadyClicked.setText(String.valueOf(value2));
            }
            else
            {
                final Button b = (Button)findViewById(R.id.B02);
                b.setText(String.valueOf(value1));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b.setText("");
                        alreadyClicked.setText("");
                    }
                }, 1000);

                /*
                try
                {
                    b.setText(String.valueOf(value1));
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                alreadyClicked.setText("");
                alreadyClicked = null;
                b.setText("");
                */
            }
            memoryCounter = 0;
        }
        else
        {
            memoryCounter++;
            alreadyClicked = (Button)findViewById(R.id.B02);
            alreadyClicked.setText(String.valueOf(a[0][2]));
            alreadyClickedId = 02;
        }
    }

    public void clickB10(View view)
    {
        if(memoryCounter == 1)
        {
            int value1 = a[1][0];
            int value2 = a[alreadyClickedId / 10][alreadyClickedId % 10];
            if(value1 == value2)
            {
                Button b = (Button)findViewById(R.id.B10);
                b.setText(String.valueOf(value1));
                alreadyClicked.setText(String.valueOf(value2));
            }
            else
            {
                final Button b = (Button)findViewById(R.id.B10);
                b.setText(String.valueOf(value1));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b.setText("");
                        alreadyClicked.setText("");
                    }
                }, 1000);

                /*
                try
                {
                    b.setText(String.valueOf(value1));
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                alreadyClicked.setText("");
                alreadyClicked = null;
                b.setText("");
                */
            }
            memoryCounter = 0;
        }
        else
        {
            memoryCounter++;
            alreadyClicked = (Button)findViewById(R.id.B10);
            alreadyClicked.setText(String.valueOf(a[1][0]));
            alreadyClickedId = 10;
        }
    }

    public void clickB11(View view)
    {
        if(memoryCounter == 1)
        {
            int value1 = a[1][1];
            int value2 = a[alreadyClickedId / 10][alreadyClickedId % 10];
            if(value1 == value2)
            {
                Button b = (Button)findViewById(R.id.B11);
                b.setText(String.valueOf(value1));
                alreadyClicked.setText(String.valueOf(value2));
            }
            else
            {
                final Button b = (Button)findViewById(R.id.B11);
                b.setText(String.valueOf(value1));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b.setText("");
                        alreadyClicked.setText("");
                    }
                }, 1000);

                /*
                try
                {
                    b.setText(String.valueOf(value1));
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                alreadyClicked.setText("");
                alreadyClicked = null;
                b.setText("");
                */
            }
            memoryCounter = 0;
        }
        else
        {
            memoryCounter++;
            alreadyClicked = (Button)findViewById(R.id.B11);
            alreadyClicked.setText(String.valueOf(a[1][1]));
            alreadyClickedId = 11;
        }
    }

    public void clickB12(View view)
    {
        if(memoryCounter == 1)
        {
            int value1 = a[1][2];
            int value2 = a[alreadyClickedId / 10][alreadyClickedId % 10];
            if(value1 == value2)
            {
                Button b = (Button)findViewById(R.id.B12);
                b.setText(String.valueOf(value1));
                alreadyClicked.setText(String.valueOf(value2));
            }
            else
            {
                final Button b = (Button)findViewById(R.id.B12);
                b.setText(String.valueOf(value1));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b.setText("");
                        alreadyClicked.setText("");
                    }
                }, 1000);

                /*
                try
                {
                    b.setText(String.valueOf(value1));
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                alreadyClicked.setText("");
                alreadyClicked = null;
                b.setText("");
                */
            }
            memoryCounter = 0;
        }
        else
        {
            memoryCounter++;
            alreadyClicked = (Button)findViewById(R.id.B12);
            alreadyClicked.setText(String.valueOf(a[1][2]));
            alreadyClickedId = 12;
        }
    }

    public void clickB20(View view)
    {
        if(memoryCounter == 1)
        {
            int value1 = a[2][0];
            int value2 = a[alreadyClickedId / 10][alreadyClickedId % 10];
            if(value1 == value2)
            {
                Button b = (Button)findViewById(R.id.B20);
                b.setText(String.valueOf(value1));
                alreadyClicked.setText(String.valueOf(value2));
            }
            else
            {
                final Button b = (Button)findViewById(R.id.B20);
                b.setText(String.valueOf(value1));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b.setText("");
                        alreadyClicked.setText("");
                    }
                }, 1000);

                /*
                try
                {
                    b.setText(String.valueOf(value1));
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                alreadyClicked.setText("");
                alreadyClicked = null;
                b.setText("");
                */
            }
            memoryCounter = 0;
        }
        else
        {
            memoryCounter++;
            alreadyClicked = (Button)findViewById(R.id.B20);
            alreadyClicked.setText(String.valueOf(a[2][0]));
            alreadyClickedId = 20;
        }
    }

    public void clickB21(View view)
    {
        if(memoryCounter == 1)
        {
            int value1 = a[2][1];
            int value2 = a[alreadyClickedId / 10][alreadyClickedId % 10];
            if(value1 == value2)
            {
                Button b = (Button)findViewById(R.id.B21);
                b.setText(String.valueOf(value1));
                alreadyClicked.setText(String.valueOf(value2));
            }
            else
            {
                final Button b = (Button)findViewById(R.id.B21);
                b.setText(String.valueOf(value1));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b.setText("");
                        alreadyClicked.setText("");
                    }
                }, 1000);

                /*
                try
                {
                    b.setText(String.valueOf(value1));
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                alreadyClicked.setText("");
                alreadyClicked = null;
                b.setText("");
                */
            }
            memoryCounter = 0;
        }
        else
        {
            memoryCounter++;
            alreadyClicked = (Button)findViewById(R.id.B21);
            alreadyClicked.setText(String.valueOf(a[2][1]));
            alreadyClickedId = 21;
        }
    }

    public void clickB22(View view)
    {
        if(memoryCounter == 1)
        {
            int value1 = a[2][2];
            int value2 = a[alreadyClickedId / 10][alreadyClickedId % 10];
            if(value1 == value2)
            {
                Button b = (Button)findViewById(R.id.B22);
                b.setText(String.valueOf(value1));
                alreadyClicked.setText(String.valueOf(value2));
            }
            else
            {
                final Button b = (Button)findViewById(R.id.B22);
                b.setText(String.valueOf(value1));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b.setText("");
                        alreadyClicked.setText("");
                    }
                }, 1000);

                /*
                try
                {
                    b.setText(String.valueOf(value1));
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                alreadyClicked.setText("");
                alreadyClicked = null;
                b.setText("");
                */
            }
            memoryCounter = 0;
        }
        else
        {
            memoryCounter++;
            alreadyClicked = (Button)findViewById(R.id.B22);
            alreadyClicked.setText(String.valueOf(a[2][2]));
            alreadyClickedId = 22;
        }
    }

    public void clickB30(View view)
    {
        if(memoryCounter == 1)
        {
            int value1 = a[3][0];
            int value2 = a[alreadyClickedId / 10][alreadyClickedId % 10];
            if(value1 == value2)
            {
                Button b = (Button)findViewById(R.id.B30);
                b.setText(String.valueOf(value1));
                alreadyClicked.setText(String.valueOf(value2));
            }
            else
            {
                final Button b = (Button)findViewById(R.id.B30);
                b.setText(String.valueOf(value1));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b.setText("");
                        alreadyClicked.setText("");
                    }
                }, 1000);

                /*
                try
                {
                    b.setText(String.valueOf(value1));
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                alreadyClicked.setText("");
                alreadyClicked = null;
                b.setText("");
                */
            }
            memoryCounter = 0;
        }
        else
        {
            memoryCounter++;
            alreadyClicked = (Button)findViewById(R.id.B30);
            alreadyClicked.setText(String.valueOf(a[3][0]));
            alreadyClickedId = 30;
        }
    }

    public void clickB31(View view)
    {
        if(memoryCounter == 1)
        {
            int value1 = a[3][1];
            int value2 = a[alreadyClickedId / 10][alreadyClickedId % 10];
            if(value1 == value2)
            {
                Button b = (Button)findViewById(R.id.B31);
                b.setText(String.valueOf(value1));
                alreadyClicked.setText(String.valueOf(value2));
            }
            else
            {
                final Button b = (Button)findViewById(R.id.B31);
                b.setText(String.valueOf(value1));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b.setText("");
                        alreadyClicked.setText("");
                    }
                }, 1000);

                /*
                try
                {
                    b.setText(String.valueOf(value1));
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                alreadyClicked.setText("");
                alreadyClicked = null;
                b.setText("");
                */
            }
            memoryCounter = 0;
        }
        else
        {
            memoryCounter++;
            alreadyClicked = (Button)findViewById(R.id.B31);
            alreadyClicked.setText(String.valueOf(a[3][1]));
            alreadyClickedId = 31;
        }
    }

    public void clickB32(View view)
    {
        if(memoryCounter == 1)
        {
            int value1 = a[3][2];
            int value2 = a[alreadyClickedId / 10][alreadyClickedId % 10];
            if(value1 == value2)
            {
                Button b = (Button)findViewById(R.id.B32);
                b.setText(String.valueOf(value1));
                alreadyClicked.setText(String.valueOf(value2));
            }
            else
            {
                final Button b = (Button)findViewById(R.id.B32);
                b.setText(String.valueOf(value1));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b.setText("");
                        alreadyClicked.setText("");
                    }
                }, 1000);

                /*
                try
                {
                    b.setText(String.valueOf(value1));
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                alreadyClicked.setText("");
                alreadyClicked = null;
                b.setText("");
                */
            }
            memoryCounter = 0;
        }
        else
        {
            memoryCounter++;
            alreadyClicked = (Button)findViewById(R.id.B32);
            alreadyClicked.setText(String.valueOf(a[3][2]));
            alreadyClickedId = 32;
        }
    }
}
