.class Lcom/livemixtapes/NowPlayingActivity$6;
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
    iput-object p1, p0, Lcom/livemixtapes/NowPlayingActivity$6;->this$0:Lcom/livemixtapes/NowPlayingActivity;

    .line 622
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 625
    sget-boolean v0, Lcom/livemixtapes/NowPlayingActivity;->repeatStatus:Z

    if-eqz v0, :cond_0

    .line 626
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->repeat:Lcom/livemixtapes/ui/FadeImageButton;

    const v1, 0x7f0200cf

    invoke-virtual {v0, v1}, Lcom/livemixtapes/ui/FadeImageButton;->setImageResource(I)V

    .line 629
    :goto_0
    sget-boolean v0, Lcom/livemixtapes/NowPlayingActivity;->repeatStatus:Z

    if-eqz v0, :cond_1

    const/4 v0, 0x0

    :goto_1
    sput-boolean v0, Lcom/livemixtapes/NowPlayingActivity;->repeatStatus:Z

    .line 630
    return-void

    .line 628
    :cond_0
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->repeat:Lcom/livemixtapes/ui/FadeImageButton;

    const v1, 0x7f0200ce

    invoke-virtual {v0, v1}, Lcom/livemixtapes/ui/FadeImageButton;->setImageResource(I)V

    goto :goto_0

    .line 629
    :cond_1
    const/4 v0, 0x1

    goto :goto_1
.end method
