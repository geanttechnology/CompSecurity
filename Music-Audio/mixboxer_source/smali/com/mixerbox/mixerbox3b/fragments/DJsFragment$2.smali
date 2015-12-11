.class Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/handmark/pulltorefresh/library/PullToRefreshBase$OnRefreshListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onRefresh(Lcom/handmark/pulltorefresh/library/PullToRefreshBase;)V
    .locals 4

    .prologue
    .line 84
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 86
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getDJsUrl(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 87
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2$1;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$2;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 124
    return-void
.end method
