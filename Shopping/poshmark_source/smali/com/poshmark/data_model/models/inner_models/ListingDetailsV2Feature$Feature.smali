.class Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature$Feature;
.super Ljava/lang/Object;
.source "ListingDetailsV2Feature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Feature"
.end annotation


# instance fields
.field enabled:Z

.field final synthetic this$0:Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature;)V
    .locals 1

    .prologue
    .line 16
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature$Feature;->this$0:Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature$Feature;->enabled:Z

    return-void
.end method
