.class public Lcom/amazon/device/utils/DetUtil$DefaultHeaderProcessor;
.super Ljava/lang/Object;
.source "DetUtil.java"

# interfaces
.implements Lcom/amazon/device/utils/DetUtil$HeaderProcessor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/utils/DetUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DefaultHeaderProcessor"
.end annotation


# instance fields
.field private final mDefaultHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

.field private final mHeaderProcessors:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/device/utils/DetUtil$HeaderProcessor;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/Map;Lcom/amazon/device/utils/DetUtil$HeaderProcessor;)V
    .locals 0
    .param p2, "defaultHeaderProcessor"    # Lcom/amazon/device/utils/DetUtil$HeaderProcessor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/device/utils/DetUtil$HeaderProcessor;",
            ">;",
            "Lcom/amazon/device/utils/DetUtil$HeaderProcessor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 116
    .local p1, "headerProcessors":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/device/utils/DetUtil$HeaderProcessor;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 117
    iput-object p1, p0, Lcom/amazon/device/utils/DetUtil$DefaultHeaderProcessor;->mHeaderProcessors:Ljava/util/Map;

    .line 118
    iput-object p2, p0, Lcom/amazon/device/utils/DetUtil$DefaultHeaderProcessor;->mDefaultHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    .line 119
    return-void
.end method


# virtual methods
.method public process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V
    .locals 2
    .param p1, "header"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "writer"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 123
    iget-object v1, p0, Lcom/amazon/device/utils/DetUtil$DefaultHeaderProcessor;->mHeaderProcessors:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    .line 124
    .local v0, "headerProcessor":Lcom/amazon/device/utils/DetUtil$HeaderProcessor;
    if-eqz v0, :cond_0

    .line 125
    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 129
    :goto_0
    return-void

    .line 127
    :cond_0
    iget-object v1, p0, Lcom/amazon/device/utils/DetUtil$DefaultHeaderProcessor;->mDefaultHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    invoke-interface {v1, p1, p2, p3}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    goto :goto_0
.end method
