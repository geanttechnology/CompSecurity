.class Lcom/poshmark/controllers/GlobalPartiesController$2;
.super Landroid/os/Handler;
.source "GlobalPartiesController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/controllers/GlobalPartiesController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/controllers/GlobalPartiesController;


# direct methods
.method constructor <init>(Lcom/poshmark/controllers/GlobalPartiesController;)V
    .locals 0

    .prologue
    .line 281
    iput-object p1, p0, Lcom/poshmark/controllers/GlobalPartiesController$2;->this$0:Lcom/poshmark/controllers/GlobalPartiesController;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 284
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 290
    :goto_0
    return-void

    .line 286
    :pswitch_0
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    .line 287
    .local v0, "eventId":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/controllers/GlobalPartiesController$2;->this$0:Lcom/poshmark/controllers/GlobalPartiesController;

    # invokes: Lcom/poshmark/controllers/GlobalPartiesController;->handleEndOfPartyTimerMessage(Ljava/lang/String;)V
    invoke-static {v1, v0}, Lcom/poshmark/controllers/GlobalPartiesController;->access$100(Lcom/poshmark/controllers/GlobalPartiesController;Ljava/lang/String;)V

    goto :goto_0

    .line 284
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
