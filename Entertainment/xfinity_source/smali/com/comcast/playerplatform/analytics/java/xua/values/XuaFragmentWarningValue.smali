.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaFragmentWarningValue.java"


# instance fields
.field private downloadDuration:I
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "DLD"
    .end annotation
.end field

.field private downloadLatency:I
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "LAT"
    .end annotation
.end field

.field private fragmentDuration:I
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "DUR"
    .end annotation
.end field

.field private fragmentSize:I
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "FSZ"
    .end annotation
.end field

.field private fragmentUrl:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "URL"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;IIII)V
    .locals 0
    .param p1, "fragmentUrl"    # Ljava/lang/String;
    .param p2, "fragmentSize"    # I
    .param p3, "downloadLatency"    # I
    .param p4, "downloadDuration"    # I
    .param p5, "fragmentDuration"    # I

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->fragmentUrl:Ljava/lang/String;

    .line 30
    iput p2, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->fragmentSize:I

    .line 31
    iput p3, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->downloadLatency:I

    .line 32
    iput p4, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->downloadDuration:I

    .line 33
    iput p5, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->fragmentDuration:I

    .line 34
    return-void
.end method


# virtual methods
.method public getDownloadDuration()I
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 65
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->downloadDuration:I

    return v0
.end method

.method public getDownloadLatency()I
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 56
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->downloadLatency:I

    return v0
.end method

.method public getFragmentDuration()I
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 74
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->fragmentDuration:I

    return v0
.end method

.method public getFragmentSize()I
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 47
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->fragmentSize:I

    return v0
.end method

.method public getFragmentUrl()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->fragmentUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setDownloadDuration(I)V
    .locals 0
    .param p1, "downloadDuration"    # I

    .prologue
    .line 69
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->downloadDuration:I

    .line 70
    return-void
.end method

.method public setDownloadLatency(I)V
    .locals 0
    .param p1, "downloadLatency"    # I

    .prologue
    .line 60
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->downloadLatency:I

    .line 61
    return-void
.end method

.method public setFragmentDuration(I)V
    .locals 0
    .param p1, "fragmentDuration"    # I

    .prologue
    .line 78
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->fragmentDuration:I

    .line 79
    return-void
.end method

.method public setFragmentSize(I)V
    .locals 0
    .param p1, "fragmentSize"    # I

    .prologue
    .line 51
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->fragmentSize:I

    .line 52
    return-void
.end method

.method public setFragmentUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "fragmentUrl"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;->fragmentUrl:Ljava/lang/String;

    .line 43
    return-void
.end method
