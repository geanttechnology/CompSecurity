.class public Lcom/amazon/searchapp/retailsearch/client/util/ClassUtil;
.super Ljava/lang/Object;
.source "ClassUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createInstance(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p0, "className"    # Ljava/lang/String;

    .prologue
    .line 18
    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 24
    :goto_0
    return-object v0

    .line 21
    :catch_0
    move-exception v0

    .line 24
    :goto_1
    const/4 v0, 0x0

    goto :goto_0

    .line 20
    :catch_1
    move-exception v0

    goto :goto_1

    .line 19
    :catch_2
    move-exception v0

    goto :goto_1
.end method
