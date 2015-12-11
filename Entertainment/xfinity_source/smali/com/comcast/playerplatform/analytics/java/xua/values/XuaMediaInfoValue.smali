.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaInfoValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaMediaInfoValue.java"


# instance fields
.field private final description:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "DESCR"
    .end annotation
.end field

.field private final position:I
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "POS"
    .end annotation
.end field


# direct methods
.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "position"    # I
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    .line 20
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaInfoValue;->position:I

    .line 21
    iput-object p2, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaInfoValue;->description:Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public getDescription()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 31
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaInfoValue;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getPosition()I
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 26
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaInfoValue;->position:I

    return v0
.end method
