.class Lnet/singular/sdk/LogsKeeper;
.super Ljava/lang/Object;
.source "LogsKeeper.java"


# instance fields
.field private lines:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lorg/json/JSONObject;",
            ">;"
        }
    .end annotation
.end field

.field private final maxSize:I


# direct methods
.method public constructor <init>(I)V
    .locals 1
    .param p1, "maxSize"    # I

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput p1, p0, Lnet/singular/sdk/LogsKeeper;->maxSize:I

    .line 14
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lnet/singular/sdk/LogsKeeper;->lines:Ljava/util/ArrayList;

    .line 15
    return-void
.end method


# virtual methods
.method public addLine(Lorg/json/JSONObject;)V
    .locals 2
    .param p1, "line"    # Lorg/json/JSONObject;

    .prologue
    .line 30
    iget-object v0, p0, Lnet/singular/sdk/LogsKeeper;->lines:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 31
    :goto_0
    iget-object v0, p0, Lnet/singular/sdk/LogsKeeper;->lines:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget v1, p0, Lnet/singular/sdk/LogsKeeper;->maxSize:I

    if-le v0, v1, :cond_0

    .line 32
    iget-object v0, p0, Lnet/singular/sdk/LogsKeeper;->lines:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    goto :goto_0

    .line 35
    :cond_0
    return-void
.end method

.method public cleanLogs()V
    .locals 1

    .prologue
    .line 18
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lnet/singular/sdk/LogsKeeper;->lines:Ljava/util/ArrayList;

    .line 19
    return-void
.end method

.method public getLogs()Lorg/json/JSONArray;
    .locals 4

    .prologue
    .line 22
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 23
    .local v2, "result":Lorg/json/JSONArray;
    iget-object v3, p0, Lnet/singular/sdk/LogsKeeper;->lines:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    .line 24
    .local v0, "cur":Lorg/json/JSONObject;
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_0

    .line 26
    .end local v0    # "cur":Lorg/json/JSONObject;
    :cond_0
    return-object v2
.end method
