.class Lcom/livemixtapes/Mixtapes$14;
.super Ljava/util/TimerTask;
.source "Mixtapes.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtapes;->setFlipperContent(Ljava/util/ArrayList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtapes;

.field private final synthetic val$data:Ljava/util/ArrayList;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtapes;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes$14;->this$0:Lcom/livemixtapes/Mixtapes;

    iput-object p2, p0, Lcom/livemixtapes/Mixtapes$14;->val$data:Ljava/util/ArrayList;

    .line 644
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/Mixtapes$14;)Lcom/livemixtapes/Mixtapes;
    .locals 1

    .prologue
    .line 644
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$14;->this$0:Lcom/livemixtapes/Mixtapes;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 647
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$14;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    new-instance v1, Lcom/livemixtapes/Mixtapes$14$1;

    iget-object v2, p0, Lcom/livemixtapes/Mixtapes$14;->val$data:Ljava/util/ArrayList;

    invoke-direct {v1, p0, v2}, Lcom/livemixtapes/Mixtapes$14$1;-><init>(Lcom/livemixtapes/Mixtapes$14;Ljava/util/ArrayList;)V

    invoke-virtual {v0, v1}, Lcom/livemixtapes/MixtapesActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 661
    return-void
.end method
