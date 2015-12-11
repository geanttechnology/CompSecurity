.class Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature$Feature;
.super Ljava/lang/Object;
.source "FeedAutoRefreshFeature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Feature"
.end annotation


# instance fields
.field auto_refresh_interval:I

.field enabled:Z

.field final synthetic this$0:Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;)V
    .locals 1

    .prologue
    .line 20
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature$Feature;->this$0:Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature$Feature;->enabled:Z

    return-void
.end method
