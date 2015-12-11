.class public abstract Lcom/comcast/cim/android/view/launch/LaunchStrategy;
.super Ljava/lang/Object;
.source "LaunchStrategy.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createExitBundle()Landroid/os/Bundle;
    .locals 3

    .prologue
    .line 48
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 49
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "exit"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 50
    return-object v0
.end method

.method public exitApp(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 22
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/comcast/cim/android/view/launch/LaunchActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 23
    .local v0, "exitIntent":Landroid/content/Intent;
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;->createExitBundle()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 26
    const/high16 v1, 0x64000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 30
    invoke-virtual {p1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 31
    invoke-virtual {p1}, Landroid/app/Activity;->finish()V

    .line 32
    return-void
.end method

.method public abstract getDefaultActivityClass()Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end method

.method public restartAppFlow(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 14
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/comcast/cim/android/view/launch/LaunchActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 15
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x24000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 18
    invoke-virtual {p1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 19
    return-void
.end method
