.class Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1$1;
.super Ljava/lang/Object;
.source "AnalyticsSenderFactory.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;->execute()Ljava/lang/Void;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/comcast/cim/cmasl/analytics/AnalyticsResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;)V
    .locals 0

    .prologue
    .line 44
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1.1;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1$1;->this$1:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/cmasl/analytics/AnalyticsResponseHandler;
    .locals 1

    .prologue
    .line 47
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1.1;"
    new-instance v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsResponseHandler;

    invoke-direct {v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsResponseHandler;-><init>()V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 44
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1.1;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1$1;->get()Lcom/comcast/cim/cmasl/analytics/AnalyticsResponseHandler;

    move-result-object v0

    return-object v0
.end method
