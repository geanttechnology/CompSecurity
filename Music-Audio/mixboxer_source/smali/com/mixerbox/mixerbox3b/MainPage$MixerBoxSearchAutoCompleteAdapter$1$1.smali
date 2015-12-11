.class Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$2:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;

.field final synthetic val$results:Landroid/widget/Filter$FilterResults;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;Landroid/widget/Filter$FilterResults;)V
    .locals 0

    .prologue
    .line 4126
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1$1;->this$2:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1$1;->val$results:Landroid/widget/Filter$FilterResults;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 4128
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1$1;->this$2:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1$1;->val$results:Landroid/widget/Filter$FilterResults;

    iget-object v0, v0, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    check-cast v0, Ljava/util/ArrayList;

    # setter for: Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->resultList:Ljava/util/ArrayList;
    invoke-static {v1, v0}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->access$1102(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    .line 4129
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1$1;->val$results:Landroid/widget/Filter$FilterResults;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1$1;->val$results:Landroid/widget/Filter$FilterResults;

    iget v0, v0, Landroid/widget/Filter$FilterResults;->count:I

    if-lez v0, :cond_0

    .line 4130
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1$1;->this$2:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->notifyDataSetChanged()V

    .line 4134
    :goto_0
    return-void

    .line 4132
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1$1;->this$2:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->notifyDataSetInvalidated()V

    goto :goto_0
.end method
