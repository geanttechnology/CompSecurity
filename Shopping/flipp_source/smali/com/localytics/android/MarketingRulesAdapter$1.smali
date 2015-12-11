.class Lcom/localytics/android/MarketingRulesAdapter$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/localytics/android/MarketingRulesAdapter;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingRulesAdapter;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/localytics/android/MarketingRulesAdapter$1;->this$0:Lcom/localytics/android/MarketingRulesAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Ljava/lang/Boolean;
    .locals 4

    .prologue
    .line 49
    const/4 v0, 0x0

    .line 51
    iget-object v1, p0, Lcom/localytics/android/MarketingRulesAdapter$1;->this$0:Lcom/localytics/android/MarketingRulesAdapter;

    # getter for: Lcom/localytics/android/MarketingRulesAdapter;->mHandler:Lcom/localytics/android/MarketingHandler;
    invoke-static {v1}, Lcom/localytics/android/MarketingRulesAdapter;->access$000(Lcom/localytics/android/MarketingRulesAdapter;)Lcom/localytics/android/MarketingHandler;

    move-result-object v1

    invoke-virtual {v1}, Lcom/localytics/android/MarketingHandler;->getMarketingMessages()Ljava/util/List;

    move-result-object v1

    .line 52
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingMessage;

    .line 54
    const/4 v1, 0x1

    .line 55
    iget-object v3, p0, Lcom/localytics/android/MarketingRulesAdapter$1;->this$0:Lcom/localytics/android/MarketingRulesAdapter;

    # getter for: Lcom/localytics/android/MarketingRulesAdapter;->mMarketingRules:Ljava/util/List;
    invoke-static {v3}, Lcom/localytics/android/MarketingRulesAdapter;->access$100(Lcom/localytics/android/MarketingRulesAdapter;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move v0, v1

    .line 56
    goto :goto_0

    .line 58
    :cond_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 45
    invoke-virtual {p0}, Lcom/localytics/android/MarketingRulesAdapter$1;->call()Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method
