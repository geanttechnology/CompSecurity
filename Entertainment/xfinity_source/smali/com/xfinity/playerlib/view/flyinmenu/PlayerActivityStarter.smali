.class public Lcom/xfinity/playerlib/view/flyinmenu/PlayerActivityStarter;
.super Lcom/comcast/cim/android/sideribbon/ActivityStarter;
.source "PlayerActivityStarter.java"


# direct methods
.method public constructor <init>(Ljava/lang/Class;Landroid/app/Activity;)V
    .locals 0
    .param p2, "activity"    # Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;",
            "Landroid/app/Activity;",
            ")V"
        }
    .end annotation

    .prologue
    .line 16
    .local p1, "targetClazz":Ljava/lang/Class;, "Ljava/lang/Class<+Landroid/app/Activity;>;"
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/android/sideribbon/ActivityStarter;-><init>(Ljava/lang/Class;Landroid/app/Activity;)V

    .line 17
    return-void
.end method
