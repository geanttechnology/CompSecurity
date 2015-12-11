.class public Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
.super Ljava/lang/Object;
.source "XuaHeartbeatEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "HeartbeatFragment"
.end annotation


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

.field private fragmentDuration:Ljava/lang/Integer;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "DUR"
    .end annotation
.end field

.field private fragmentSize:I
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "FSZ"
    .end annotation
.end field

.field private numberOfFragments:I
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "NOF"
    .end annotation
.end field


# direct methods
.method public constructor <init>(IIIILjava/lang/Integer;)V
    .locals 0
    .param p1, "numFragments"    # I
    .param p2, "fragmentSize"    # I
    .param p3, "downloadLatency"    # I
    .param p4, "downloadDur"    # I
    .param p5, "fragmentDur"    # Ljava/lang/Integer;

    .prologue
    .line 171
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 172
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->numberOfFragments:I

    .line 173
    iput p2, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->fragmentSize:I

    .line 174
    iput p3, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->downloadLatency:I

    .line 175
    iput p4, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->downloadDuration:I

    .line 176
    iput-object p5, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->fragmentDuration:Ljava/lang/Integer;

    .line 177
    return-void
.end method


# virtual methods
.method public getDownloadDuration()I
    .locals 1

    .prologue
    .line 204
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->downloadDuration:I

    return v0
.end method

.method public getDownloadLatency()I
    .locals 1

    .prologue
    .line 196
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->downloadLatency:I

    return v0
.end method

.method public getFragmentDuration()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->fragmentDuration:Ljava/lang/Integer;

    return-object v0
.end method

.method public getFragmentSize()I
    .locals 1

    .prologue
    .line 188
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->fragmentSize:I

    return v0
.end method

.method public getNumberOfFragments()I
    .locals 1

    .prologue
    .line 180
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->numberOfFragments:I

    return v0
.end method

.method public setDownloadDuration(I)V
    .locals 0
    .param p1, "downloadDuration"    # I

    .prologue
    .line 208
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->downloadDuration:I

    .line 209
    return-void
.end method

.method public setDownloadLatency(I)V
    .locals 0
    .param p1, "downloadLatency"    # I

    .prologue
    .line 200
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->downloadLatency:I

    .line 201
    return-void
.end method

.method public setFragmentDuration(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "fragmentDuration"    # Ljava/lang/Integer;

    .prologue
    .line 216
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->fragmentDuration:Ljava/lang/Integer;

    .line 217
    return-void
.end method

.method public setFragmentSize(I)V
    .locals 0
    .param p1, "fragmentSize"    # I

    .prologue
    .line 192
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->fragmentSize:I

    .line 193
    return-void
.end method

.method public setNumberOfFragments(I)V
    .locals 0
    .param p1, "numberOfFragments"    # I

    .prologue
    .line 184
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;->numberOfFragments:I

    .line 185
    return-void
.end method
