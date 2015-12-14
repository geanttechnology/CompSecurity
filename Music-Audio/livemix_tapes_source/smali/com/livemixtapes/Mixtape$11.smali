.class Lcom/livemixtapes/Mixtape$11;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;

.field private final synthetic val$action:I


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$11;->this$0:Lcom/livemixtapes/Mixtape;

    iput p2, p0, Lcom/livemixtapes/Mixtape$11;->val$action:I

    .line 773
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 776
    iget v0, p0, Lcom/livemixtapes/Mixtape$11;->val$action:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 777
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$11;->this$0:Lcom/livemixtapes/Mixtape;

    invoke-virtual {v0}, Lcom/livemixtapes/Mixtape;->playAll()V

    .line 781
    :cond_0
    :goto_0
    return-void

    .line 778
    :cond_1
    iget v0, p0, Lcom/livemixtapes/Mixtape$11;->val$action:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 779
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$11;->this$0:Lcom/livemixtapes/Mixtape;

    invoke-virtual {v0}, Lcom/livemixtapes/Mixtape;->downloadAll()V

    goto :goto_0
.end method
