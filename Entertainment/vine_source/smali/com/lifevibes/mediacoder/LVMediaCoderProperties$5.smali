.class final Lcom/lifevibes/mediacoder/LVMediaCoderProperties$5;
.super Ljava/util/ArrayList;
.source "LVMediaCoderProperties.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/lifevibes/mediacoder/LVMediaCoderProperties;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/ArrayList",
        "<",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x1L


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 225
    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    .line 231
    const/16 v0, 0xf

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties$5;->add(Ljava/lang/Object;)Z

    .line 232
    const/16 v0, 0x18

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties$5;->add(Ljava/lang/Object;)Z

    .line 233
    const/16 v0, 0x19

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties$5;->add(Ljava/lang/Object;)Z

    .line 234
    const/16 v0, 0x1e

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties$5;->add(Ljava/lang/Object;)Z

    .line 235
    return-void
.end method
