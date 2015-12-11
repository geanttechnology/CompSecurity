.class public Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;
.super Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;
.source "FlowImageMatchObjectInfo.java"


# instance fields
.field private m_asins:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
    .locals 1
    .param p1, "a_objectInfo"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    .prologue
    .line 16
    invoke-direct {p0, p1}, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 13
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;->m_asins:Ljava/util/List;

    .line 17
    return-void
.end method


# virtual methods
.method public getAsins()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 24
    iget-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;->m_asins:Ljava/util/List;

    if-nez v0, :cond_0

    .line 25
    iget-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;->m_objectInfo:Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->getAlternatives()Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    move-result-object v0

    invoke-static {v0}, Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;->getListOfStrings(Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;->m_asins:Ljava/util/List;

    .line 27
    iget-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;->m_asins:Ljava/util/List;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;->m_objectInfo:Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    invoke-virtual {v2}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->getContent()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 29
    :cond_0
    iget-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;->m_asins:Ljava/util/List;

    return-object v0
.end method
