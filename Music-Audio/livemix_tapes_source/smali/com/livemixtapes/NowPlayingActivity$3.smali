.class Lcom/livemixtapes/NowPlayingActivity$3;
.super Ljava/lang/Object;
.source "NowPlayingActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/NowPlayingActivity;->setListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/NowPlayingActivity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/NowPlayingActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/NowPlayingActivity$3;->this$0:Lcom/livemixtapes/NowPlayingActivity;

    .line 566
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 570
    :try_start_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.livemixtapes.action.STOP"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 571
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "com.livemixtapes"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 576
    .end local v0    # "i":Landroid/content/Intent;
    :goto_0
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->nextTrack()V

    .line 577
    return-void

    .line 574
    :catch_0
    move-exception v1

    goto :goto_0
.end method
