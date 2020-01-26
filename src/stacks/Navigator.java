package stacks;

// TODO: Define the class Navigator that provides three navigation options where the user can:
//       1. Set the current link via setCurrentLink(linkName) method.
//       2. Replace the current link by going back one link via goBack() method.
//       3. Replace the current link by going forward one link via goForward() method.

public class Navigator {
    private String currentLink;
    private StackList<String> backLinks;
    private StackList<String> forwardLinks;

    public Navigator(){
        this.currentLink = "";
        this.backLinks = new StackList<>("back links");
        this.forwardLinks = new StackList<>("forward links");
    }

    public void setCurrentLink(String linkName){
        if(currentLink!=linkName){
            //adds the top link to the backLinks list
            if(currentLink!="") {
                backLinks.push(currentLink);
            }
            //clears the forwardLinks
            forwardLinks.clear();
            //sets new currentLink to passed in variable
            currentLink = linkName;

        }
    }

    public void goBack(){
        //only operate method if backLinks isn't empty
        if(backLinks.size()==0){
            return;
        }
        //pushes current link to forward links
        forwardLinks.push(currentLink);
        //removes first node in backLinks and sets it to currentLink
        currentLink = backLinks.pop();

    }

    public void goForward(){
        //only operate method if forwardLinks isn't empty
        if(backLinks.size()==0){
            return;
        }
        //pushes current link to backLinks
        backLinks.push(currentLink);
        //removes first node in forwardLinks and sets it to currentLink
        currentLink = forwardLinks.pop();
    }

    public String getCurrentLink() {
        return currentLink;
    }

    public StackList<String> getBackLinks() {
        return backLinks;
    }

    public StackList<String> getForwardLinks() {
        return forwardLinks;
    }
}

