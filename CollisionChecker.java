package Controller;

import Entity.Entity;
import Controller.TileManager;
import View.ViewPanel;

public class CollisionChecker {
    

        ViewPanel vp;
        TileManager tileM;

        public CollisionChecker(ViewPanel vp) {
            this.vp = vp;

        }
        public void checkTile(Entity entity) {

            int entityLeftWorldx = entity.x + entity.solidArea.x;
            int entityRightWorldx = entity.x + entity.solidArea.x + entity.solidArea.width;
            int entityTopWorldy = entity.y + entity.solidArea.y;
            int entityBottomWorldy = entity.y + entity.solidArea.y + entity.solidArea.height;

            int entityLeftCol = entityLeftWorldx/vp.Tilesize;
            int entityRightCol = entityRightWorldx/vp.Tilesize;
            int entityTopRow = entityTopWorldy/vp.Tilesize;
            int entityBottomRow = entityBottomWorldy/vp.Tilesize;

            int tileNum1,tileNum2;

            switch(entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldy - entity.speed)/vp.Tilesize;
                tileNum1 = vp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = vp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (vp.tileM.tile[tileNum1].collision == true || vp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldy + entity.speed)/vp.Tilesize;
                tileNum1 = vp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = vp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (vp.tileM.tile[tileNum1].collision == true || vp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldx - entity.speed)/vp.Tilesize;
                tileNum1 = vp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = vp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (vp.tileM.tile[tileNum1].collision == true || vp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldx + entity.speed)/vp.Tilesize;
                tileNum1 = vp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = vp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (vp.tileM.tile[tileNum1].collision == true && vp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            }
        }
        public int checkobject(Entity entity, boolean player) {
            int index = 999;


            for (int i = 0;i < vp.obj.length; i++) {

                if(vp.obj[i] != null) {
                    entity.solidArea.x = entity.x + entity.solidArea.x;
                    entity.solidArea.y = entity.y + entity.solidArea.y;

                    vp.obj[i].solidArea.x = vp.obj[i].mapx + vp.obj[i].solidArea.x;
                    vp.obj[i].solidArea.y = vp.obj[i].mapy + vp.obj[i].solidArea.y;

                    switch(entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(vp.obj[i].solidArea)) {
                            System.out.println("up collision");
                            if(vp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(vp.obj[i].solidArea)) {
                            if(vp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(vp.obj[i].solidArea)) {
                            if(vp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(vp.obj[i].solidArea)) {
                            if(vp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                }
                    entity.solidArea.x = entity.solidAreaDefaultx;
                    entity.solidArea.y = entity.solidAreaDefaulty;
                    vp.obj[i].solidArea.x = vp.obj[i].solidAreaDefaultX;
                    vp.obj[i].solidArea.y =vp.obj[i].solidAreaDefaultY;

            }


        }
            return index;


       }

    }
