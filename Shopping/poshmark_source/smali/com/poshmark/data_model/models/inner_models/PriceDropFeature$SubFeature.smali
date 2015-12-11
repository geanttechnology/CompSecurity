.class public Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;
.super Ljava/lang/Object;
.source "PriceDropFeature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "SubFeature"
.end annotation


# instance fields
.field public enabled:Z

.field final synthetic this$0:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;)V
    .locals 1

    .prologue
    .line 15
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;->this$0:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;->enabled:Z

    return-void
.end method
