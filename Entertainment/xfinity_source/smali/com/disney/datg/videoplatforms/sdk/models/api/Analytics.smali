.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Analytics;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "analytics"
    strict = false
.end annotation


# instance fields
.field private tracker:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Tracker;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
        name = "tracker"
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Analytics;->tracker:Ljava/util/ArrayList;

    return-void
.end method
