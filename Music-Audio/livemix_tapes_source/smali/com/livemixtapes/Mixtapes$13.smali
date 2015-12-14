.class Lcom/livemixtapes/Mixtapes$13;
.super Ljava/lang/Object;
.source "Mixtapes.java"

# interfaces
.implements Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;


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
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes$13;->this$0:Lcom/livemixtapes/Mixtapes;

    iput-object p2, p0, Lcom/livemixtapes/Mixtapes$13;->val$data:Ljava/util/ArrayList;

    .line 569
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onShowMixtape(II)V
    .locals 2
    .param p1, "position"    # I
    .param p2, "action"    # I

    .prologue
    .line 573
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$13;->val$data:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    .line 574
    .local v0, "tracksData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$13;->this$0:Lcom/livemixtapes/Mixtapes;

    # invokes: Lcom/livemixtapes/Mixtapes;->loadMixtapeFragment(Ljava/util/HashMap;I)V
    invoke-static {v1, v0, p2}, Lcom/livemixtapes/Mixtapes;->access$7(Lcom/livemixtapes/Mixtapes;Ljava/util/HashMap;I)V

    .line 575
    return-void
.end method
