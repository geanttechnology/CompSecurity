.class public Lcom/comcast/cim/httpcomponentsandroid/params/SyncBasicHttpParams;
.super Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;
.source "SyncBasicHttpParams.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;-><init>()V

    .line 40
    return-void
.end method


# virtual methods
.method public declared-synchronized clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 71
    monitor-enter p0

    :try_start_0
    invoke-super {p0}, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;->clone()Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getParameter(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 51
    monitor-enter p0

    :try_start_0
    invoke-super {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 47
    monitor-enter p0

    :try_start_0
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
