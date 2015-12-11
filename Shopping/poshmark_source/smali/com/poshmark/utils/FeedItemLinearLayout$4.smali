.class Lcom/poshmark/utils/FeedItemLinearLayout$4;
.super Ljava/lang/Object;
.source "FeedItemLinearLayout.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/FeedItemLinearLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/FeedItemLinearLayout;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/FeedItemLinearLayout;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Lcom/poshmark/utils/FeedItemLinearLayout$4;->this$0:Lcom/poshmark/utils/FeedItemLinearLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 149
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/FeedItem;

    .line 151
    .local v1, "feedItem":Lcom/poshmark/data_model/models/FeedItem;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/FeedItem;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    move-result-object v3

    .line 152
    .local v3, "storyType":Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;
    sget-object v4, Lcom/poshmark/utils/FeedItemLinearLayout$5;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemStoryType$StoryType:[I

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 172
    :pswitch_0
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 173
    .local v2, "parentActivity":Lcom/poshmark/ui/PMActivity;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 174
    .local v0, "b":Landroid/os/Bundle;
    const-string v4, "NAME"

    iget-object v5, v1, Lcom/poshmark/data_model/models/FeedItem;->actor:Lcom/poshmark/data_model/models/Actor;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/Actor;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    const-class v4, Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-virtual {v2, v0, v4, v1}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 176
    return-void

    .line 152
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method
