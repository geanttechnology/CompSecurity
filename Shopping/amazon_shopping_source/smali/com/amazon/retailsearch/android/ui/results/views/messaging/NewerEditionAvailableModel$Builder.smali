.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel$Builder;
.super Ljava/lang/Object;
.source "NewerEditionAvailableModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/NewerVersion;Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
    .locals 2
    .param p1, "newerVersion"    # Lcom/amazon/searchapp/retailsearch/model/NewerVersion;
    .param p2, "productGroup"    # Ljava/lang/String;

    .prologue
    .line 91
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NewerVersion;->getAsin()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NewerVersion;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NewerVersion;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NewerVersion;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 95
    :cond_0
    const/4 v0, 0x0

    .line 104
    :goto_0
    return-object v0

    .line 98
    :cond_1
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;-><init>()V

    .line 99
    .local v0, "model":Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NewerVersion;->getAsin()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->setAsin(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;Ljava/lang/String;)V

    .line 100
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NewerVersion;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->setNewerVersionText(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->access$100(Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;Ljava/lang/String;)V

    .line 101
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NewerVersion;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->setNewerVersionUrl(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->access$200(Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;Ljava/lang/String;)V

    .line 102
    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->setProductGroup(Ljava/lang/String;)V
    invoke-static {v0, p2}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->access$300(Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;Ljava/lang/String;)V

    goto :goto_0
.end method
