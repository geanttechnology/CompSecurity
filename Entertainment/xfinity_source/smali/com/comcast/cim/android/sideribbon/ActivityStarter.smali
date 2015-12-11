.class public Lcom/comcast/cim/android/sideribbon/ActivityStarter;
.super Ljava/lang/Object;
.source "ActivityStarter.java"

# interfaces
.implements Lcom/comcast/cim/android/sideribbon/SlideClosedListener;


# instance fields
.field protected final activity:Landroid/app/Activity;

.field protected final intent:Landroid/content/Intent;


# direct methods
.method public constructor <init>(Landroid/content/Intent;Landroid/app/Activity;)V
    .locals 0
    .param p1, "intentToStart"    # Landroid/content/Intent;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/comcast/cim/android/sideribbon/ActivityStarter;->intent:Landroid/content/Intent;

    .line 12
    iput-object p2, p0, Lcom/comcast/cim/android/sideribbon/ActivityStarter;->activity:Landroid/app/Activity;

    .line 13
    return-void
.end method

.method public constructor <init>(Ljava/lang/Class;Landroid/app/Activity;)V
    .locals 1
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
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p2, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-direct {p0, v0, p2}, Lcom/comcast/cim/android/sideribbon/ActivityStarter;-><init>(Landroid/content/Intent;Landroid/app/Activity;)V

    .line 17
    return-void
.end method


# virtual methods
.method public onCloseFinished()V
    .locals 2

    .prologue
    .line 21
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/ActivityStarter;->activity:Landroid/app/Activity;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/ActivityStarter;->intent:Landroid/content/Intent;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 22
    return-void
.end method
