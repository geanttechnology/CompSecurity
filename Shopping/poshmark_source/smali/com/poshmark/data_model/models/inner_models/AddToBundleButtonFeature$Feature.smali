.class Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature$Feature;
.super Ljava/lang/Object;
.source "AddToBundleButtonFeature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Feature"
.end annotation


# instance fields
.field enabled:Z

.field final synthetic this$0:Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;

.field title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;)V
    .locals 1

    .prologue
    .line 24
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature$Feature;->this$0:Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature$Feature;->enabled:Z

    return-void
.end method
