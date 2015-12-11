.class Lcom/localytics/android/MarketingHandler$24;
.super Lcom/localytics/android/MarketingCallable;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/localytics/android/MarketingHandler;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingHandler;)V
    .locals 0

    .prologue
    .line 2795
    iput-object p1, p0, Lcom/localytics/android/MarketingHandler$24;->this$0:Lcom/localytics/android/MarketingHandler;

    invoke-direct {p0}, Lcom/localytics/android/MarketingCallable;-><init>()V

    return-void
.end method


# virtual methods
.method call([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    .line 2799
    const/4 v0, 0x0

    aget-object v0, p1, v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 2800
    const/4 v0, 0x1

    aget-object v0, p1, v0

    check-cast v0, Ljava/lang/String;

    .line 2801
    iget-object v2, p0, Lcom/localytics/android/MarketingHandler$24;->this$0:Lcom/localytics/android/MarketingHandler;

    iget-object v2, v2, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2, v1, v0}, Lcom/localytics/android/LocalyticsDao;->setCustomDimension(ILjava/lang/String;)V

    .line 2803
    const/4 v0, 0x0

    return-object v0
.end method
