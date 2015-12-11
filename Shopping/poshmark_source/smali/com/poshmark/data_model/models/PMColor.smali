.class public Lcom/poshmark/data_model/models/PMColor;
.super Ljava/lang/Object;
.source "PMColor.java"


# instance fields
.field public name:Ljava/lang/String;

.field public rgb:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "rgb"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/poshmark/data_model/models/PMColor;->name:Ljava/lang/String;

    .line 16
    iput-object p2, p0, Lcom/poshmark/data_model/models/PMColor;->rgb:Ljava/lang/String;

    .line 17
    return-void
.end method

.method public static clone(Lcom/poshmark/data_model/models/PMColor;)Lcom/poshmark/data_model/models/PMColor;
    .locals 3
    .param p0, "color"    # Lcom/poshmark/data_model/models/PMColor;

    .prologue
    .line 24
    new-instance v0, Lcom/poshmark/data_model/models/PMColor;

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMColor;->name:Ljava/lang/String;

    iget-object v2, p0, Lcom/poshmark/data_model/models/PMColor;->rgb:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/PMColor;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMColor;->name:Ljava/lang/String;

    return-object v0
.end method
