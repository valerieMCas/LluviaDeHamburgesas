/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamebase.elements;

import java.util.ArrayList;

/**
 *
 * @author marti
 */
public abstract class SpriteContainer extends Sprite implements GraphicContainer
{
    protected ArrayList<Sprite> sprites;   
    
    public SpriteContainer(int x, int y, int height, int width) {
        super(x, y, height, width);
        
        sprites = new ArrayList<Sprite>();
    }   
    
    public boolean add(Sprite sprite)
    {
        return sprites.add(sprite);
    }
    
    public void remove(int index)
    {
        sprites.remove(index);
    }

    public void remove(Sprite sprite)
    {
        sprites.remove(sprite);
    }
    
    public int size()
    {
        return sprites.size();
    }
}
