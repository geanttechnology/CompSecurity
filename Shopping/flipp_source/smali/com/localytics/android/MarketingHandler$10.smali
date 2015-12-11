.class Lcom/localytics/android/MarketingHandler$10;
.super Lcom/localytics/android/MarketingCallable;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/localytics/android/MarketingHandler;

.field final synthetic val$adapter:Lcom/localytics/android/MarketingRulesAdapter;

.field final synthetic val$listView:Lcom/localytics/android/TestModeListView;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/MarketingRulesAdapter;Lcom/localytics/android/TestModeListView;)V
    .locals 0

    .prologue
    .line 2241
    iput-object p1, p0, Lcom/localytics/android/MarketingHandler$10;->this$0:Lcom/localytics/android/MarketingHandler;

    iput-object p2, p0, Lcom/localytics/android/MarketingHandler$10;->val$adapter:Lcom/localytics/android/MarketingRulesAdapter;

    iput-object p3, p0, Lcom/localytics/android/MarketingHandler$10;->val$listView:Lcom/localytics/android/TestModeListView;

    invoke-direct {p0}, Lcom/localytics/android/MarketingCallable;-><init>()V

    return-void
.end method


# virtual methods
.method call([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    .line 2245
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$10;->val$adapter:Lcom/localytics/android/MarketingRulesAdapter;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingRulesAdapter;->updateDataSet()Z

    .line 2246
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$10;->val$listView:Lcom/localytics/android/TestModeListView;

    iget-object v1, p0, Lcom/localytics/android/MarketingHandler$10;->this$0:Lcom/localytics/android/MarketingHandler;

    # getter for: Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;
    invoke-static {v1}, Lcom/localytics/android/MarketingHandler;->access$300(Lcom/localytics/android/MarketingHandler;)Landroid/support/v4/app/ah;

    move-result-object v1

    const-string v2, "marketing_test_mode_list"

    invoke-virtual {v0, v1, v2}, Lcom/localytics/android/TestModeListView;->show(Landroid/support/v4/app/ah;Ljava/lang/String;)V

    .line 2247
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$10;->this$0:Lcom/localytics/android/MarketingHandler;

    # getter for: Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;
    invoke-static {v0}, Lcom/localytics/android/MarketingHandler;->access$300(Lcom/localytics/android/MarketingHandler;)Landroid/support/v4/app/ah;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/ah;->b()Z

    .line 2248
    const/4 v0, 0x0

    return-object v0
.end method
