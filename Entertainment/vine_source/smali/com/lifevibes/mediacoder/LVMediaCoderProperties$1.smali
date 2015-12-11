.class final Lcom/lifevibes/mediacoder/LVMediaCoderProperties$1;
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
    .line 166
    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    .line 172
    const/16 v0, 0xf0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties$1;->add(Ljava/lang/Object;)Z

    .line 173
    const/16 v0, 0x140

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties$1;->add(Ljava/lang/Object;)Z

    .line 174
    const/16 v0, 0x1e0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties$1;->add(Ljava/lang/Object;)Z

    .line 175
    const/16 v0, 0x280

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties$1;->add(Ljava/lang/Object;)Z

    .line 176
    const/16 v0, 0x2d0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties$1;->add(Ljava/lang/Object;)Z

    .line 177
    return-void
.end method
