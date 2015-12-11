.class public final Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnManagerParams;
.super Ljava/lang/Object;
.source "ConnManagerParams.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnManagerPNames;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field private static final DEFAULT_CONN_PER_ROUTE:Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnPerRoute;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 93
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnManagerParams$1;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnManagerParams$1;-><init>()V

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnManagerParams;->DEFAULT_CONN_PER_ROUTE:Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnPerRoute;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getTimeout(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)J
    .locals 4
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 65
    if-nez p0, :cond_0

    .line 66
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP parameters may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 68
    :cond_0
    const-string v1, "http.conn-manager.timeout"

    invoke-interface {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 69
    .local v0, "param":Ljava/lang/Long;
    if-eqz v0, :cond_1

    .line 70
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    .line 72
    :goto_0
    return-wide v2

    :cond_1
    const-string v1, "http.connection.timeout"

    const/4 v2, 0x0

    invoke-interface {p0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getIntParameter(Ljava/lang/String;I)I

    move-result v1

    int-to-long v2, v1

    goto :goto_0
.end method
