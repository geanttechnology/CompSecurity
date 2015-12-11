.class public Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent;
.super Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;
.source "PlacementViewerEvent.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;
    }
.end annotation


# instance fields
.field private spotNPT:Ljava/lang/String;

.field private type:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;


# virtual methods
.method public getEventData(Ljava/lang/StringBuffer;Ljava/lang/String;)V
    .locals 5
    .param p1, "stringBuffer"    # Ljava/lang/StringBuffer;
    .param p2, "timestamp"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 21
    const-string v0, "<ViewerEvent time=\"%s\" type=\"%s\" >"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p2, v1, v3

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent;->type:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 23
    const-string v0, "<SpotNPT scale=\"1.0\">%s</SpotNPT>"

    new-array v1, v4, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent;->spotNPT:Ljava/lang/String;

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 25
    const-string v0, "</ViewerEvent>"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 26
    return-void
.end method

.method public isEndAll()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method
