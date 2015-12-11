.class Lorg/simpleframework/xml/core/GroupExtractor$Registry;
.super Ljava/util/LinkedHashMap;
.source "GroupExtractor.java"

# interfaces
.implements Ljava/lang/Iterable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/simpleframework/xml/core/GroupExtractor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Registry"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/LinkedHashMap",
        "<",
        "Ljava/lang/Class;",
        "Lorg/simpleframework/xml/core/Label;",
        ">;",
        "Ljava/lang/Iterable",
        "<",
        "Lorg/simpleframework/xml/core/Label;",
        ">;"
    }
.end annotation


# instance fields
.field private final elements:Lorg/simpleframework/xml/core/LabelMap;


# direct methods
.method public constructor <init>(Lorg/simpleframework/xml/core/LabelMap;)V
    .locals 0
    .param p1, "elements"    # Lorg/simpleframework/xml/core/LabelMap;

    .prologue
    .line 253
    invoke-direct {p0}, Ljava/util/LinkedHashMap;-><init>()V

    .line 254
    iput-object p1, p0, Lorg/simpleframework/xml/core/GroupExtractor$Registry;->elements:Lorg/simpleframework/xml/core/LabelMap;

    .line 255
    return-void
.end method


# virtual methods
.method public iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lorg/simpleframework/xml/core/Label;",
            ">;"
        }
    .end annotation

    .prologue
    .line 265
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/GroupExtractor$Registry;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public register(Ljava/lang/Class;Ljava/lang/String;Lorg/simpleframework/xml/core/Label;)V
    .locals 2
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "label"    # Lorg/simpleframework/xml/core/Label;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 300
    new-instance v0, Lorg/simpleframework/xml/core/CacheLabel;

    invoke-direct {v0, p3}, Lorg/simpleframework/xml/core/CacheLabel;-><init>(Lorg/simpleframework/xml/core/Label;)V

    .line 302
    .local v0, "cache":Lorg/simpleframework/xml/core/Label;
    iget-object v1, p0, Lorg/simpleframework/xml/core/GroupExtractor$Registry;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v1, p2}, Lorg/simpleframework/xml/core/LabelMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 303
    iget-object v1, p0, Lorg/simpleframework/xml/core/GroupExtractor$Registry;->elements:Lorg/simpleframework/xml/core/LabelMap;

    invoke-virtual {v1, p2, v0}, Lorg/simpleframework/xml/core/LabelMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 305
    :cond_0
    invoke-virtual {p0, p1}, Lorg/simpleframework/xml/core/GroupExtractor$Registry;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 306
    invoke-virtual {p0, p1, v0}, Lorg/simpleframework/xml/core/GroupExtractor$Registry;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 308
    :cond_1
    return-void
.end method

.method public resolve(Ljava/lang/Class;)Lorg/simpleframework/xml/core/Label;
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;

    .prologue
    .line 280
    :goto_0
    if-eqz p1, :cond_1

    .line 281
    invoke-virtual {p0, p1}, Lorg/simpleframework/xml/core/GroupExtractor$Registry;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/simpleframework/xml/core/Label;

    .line 283
    .local v0, "label":Lorg/simpleframework/xml/core/Label;
    if-eqz v0, :cond_0

    .line 288
    .end local v0    # "label":Lorg/simpleframework/xml/core/Label;
    :goto_1
    return-object v0

    .line 286
    .restart local v0    # "label":Lorg/simpleframework/xml/core/Label;
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object p1

    .line 287
    goto :goto_0

    .line 288
    .end local v0    # "label":Lorg/simpleframework/xml/core/Label;
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method
