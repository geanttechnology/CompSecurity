.class public Lcom/poshmark/data_model/models/Colors;
.super Ljava/lang/Object;
.source "Colors.java"


# static fields
.field public static colorHash:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 15
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    .line 16
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Red"

    const-string v2, "#FF3300"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 17
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Pink"

    const-string v2, "#FF0066"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 18
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Orange"

    const-string v2, "#FF6600"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 19
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Yellow"

    const-string v2, "#FFFF00"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 20
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Green"

    const-string v2, "#009900"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 21
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Blue"

    const-string v2, "#0066FF"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 22
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Purple"

    const-string v2, "#9933FF"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 23
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Gold"

    const-string v2, "#FFCC00"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 24
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Silver"

    const-string v2, "#F0FFFF"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Black"

    const-string v2, "#000000"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Gray"

    const-string v2, "#808080"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 27
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "White"

    const-string v2, "#FFFFFF"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 28
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Cream"

    const-string v2, "#FFFFCC"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 29
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Brown"

    const-string v2, "#5E3914"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 30
    sget-object v0, Lcom/poshmark/data_model/models/Colors;->colorHash:Ljava/util/Map;

    const-string v1, "Tan"

    const-string v2, "#5E3914"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
