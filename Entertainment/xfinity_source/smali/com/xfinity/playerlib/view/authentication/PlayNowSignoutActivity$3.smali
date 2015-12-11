.class Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$3;
.super Ljava/lang/Object;
.source "PlayNowSignoutActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$3;->this$0:Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 74
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$3;->this$0:Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->finish()V

    .line 75
    return-void
.end method
