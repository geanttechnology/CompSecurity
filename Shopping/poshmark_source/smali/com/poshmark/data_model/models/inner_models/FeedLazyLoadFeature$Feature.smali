.class Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature$Feature;
.super Ljava/lang/Object;
.source "FeedLazyLoadFeature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Feature"
.end annotation


# instance fields
.field bubble_display_interval:I

.field enabled:Z

.field final synthetic this$0:Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;

.field title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;)V
    .locals 1

    .prologue
    .line 26
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature$Feature;->this$0:Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature$Feature;->enabled:Z

    return-void
.end method
