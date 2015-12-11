.class public Lcom/comcast/cim/httpcomponentsandroid/impl/auth/BasicSchemeFactory;
.super Ljava/lang/Object;
.source "BasicSchemeFactory.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeFactory;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public newInstance(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    .locals 1
    .param p1, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 46
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/BasicScheme;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/BasicScheme;-><init>()V

    return-object v0
.end method
