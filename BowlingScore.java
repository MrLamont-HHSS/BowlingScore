public class BowlingScore {

    private int[] rolls;
    private int currentRoll;

    public BowlingScore(){
        rolls = new int[24];
        currentRoll = 0;
    }

    public void roll(int r){
        rolls[currentRoll] = r;
        // strike happened
        if(r == 10){
            currentRoll++;
            // add 0 for next roll
            rolls[currentRoll] = 0;
        }
        currentRoll++;
    
        
    }

    public int score(){
        int score = 0;
        for(int frame = 0; frame < 10; frame++){
            // check for spare
            int roll1 = frame*2;
            int roll2 = frame*2+1;
            int roll3 = frame*2+2;
            // is a strike is found
            if(isStrike(roll1)){
                score += rolls[roll1] + rolls[roll1+2];
                // if 2 strikes in a row
                if(isStrike(roll1+2)){
                    score += rolls[roll1+4];
                }else{
                    score += rolls[roll1+3];
                }
            }
            // got a spare
            else if(rolls[roll1] + rolls[roll2] == 10){
                score += 10 + rolls[roll3];
            // normal frame
            }else{
                score += rolls[roll1] + rolls[roll2];
            }
        }
        return score;
    }

    private boolean isStrike(int roll){
        return rolls[roll] == 10;
    }
}