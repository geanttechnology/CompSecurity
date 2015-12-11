.class Lcom/mixerbox/mixerbox3b/fragments/SortFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/mobeta/android/dslv/i;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/SortFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/SortFragment;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SortFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public drop(II)V
    .locals 2

    .prologue
    .line 80
    if-eq p1, p2, :cond_0

    .line 81
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SortFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 82
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SortFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->array:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 83
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SortFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->array:Ljava/util/ArrayList;

    invoke-virtual {v1, p2, v0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 84
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SortFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SortAdapter;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/SortAdapter;->notifyDataSetChanged()V

    .line 86
    :cond_0
    return-void
.end method
