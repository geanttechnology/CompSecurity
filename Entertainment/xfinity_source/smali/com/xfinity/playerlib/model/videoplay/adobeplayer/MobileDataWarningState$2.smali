.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$2;
.super Ljava/lang/Object;
.source "MobileDataWarningState.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->postMobileDataWarningDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 90
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 91
    return-void
.end method
