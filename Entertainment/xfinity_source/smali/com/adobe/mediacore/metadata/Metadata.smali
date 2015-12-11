.class public interface abstract Lcom/adobe/mediacore/metadata/Metadata;
.super Ljava/lang/Object;


# virtual methods
.method public abstract containsKey(Ljava/lang/String;)Z
.end method

.method public abstract getByteArray(Ljava/lang/String;)[B
.end method

.method public abstract getValue(Ljava/lang/String;)Ljava/lang/String;
.end method

.method public abstract isEmpty()Z
.end method

.method public abstract keySet()Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract setByteArray(Ljava/lang/String;[B)V
.end method

.method public abstract setValue(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract toByteArray()[B
.end method
