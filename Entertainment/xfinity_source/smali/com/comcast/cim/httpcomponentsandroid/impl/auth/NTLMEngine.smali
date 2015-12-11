.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NTLMEngine;
.super Ljava/lang/Object;
.source "NTLMEngine.java"


# virtual methods
.method public abstract generateType1Msg(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NTLMEngineException;
        }
    .end annotation
.end method

.method public abstract generateType3Msg(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NTLMEngineException;
        }
    .end annotation
.end method
