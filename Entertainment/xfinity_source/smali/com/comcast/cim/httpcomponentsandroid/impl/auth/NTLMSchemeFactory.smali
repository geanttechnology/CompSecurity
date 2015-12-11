.class public Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NTLMSchemeFactory;
.super Ljava/lang/Object;
.source "NTLMSchemeFactory.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeFactory;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public newInstance(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    .locals 2
    .param p1, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 47
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NTLMScheme;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NTLMEngineImpl;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NTLMEngineImpl;-><init>()V

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NTLMScheme;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NTLMEngine;)V

    return-object v0
.end method
