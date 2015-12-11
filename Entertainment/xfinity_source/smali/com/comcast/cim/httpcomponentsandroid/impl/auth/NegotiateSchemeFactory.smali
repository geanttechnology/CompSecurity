.class public Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateSchemeFactory;
.super Ljava/lang/Object;
.source "NegotiateSchemeFactory.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeFactory;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final spengoGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/auth/SpnegoTokenGenerator;

.field private final stripPort:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 57
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateSchemeFactory;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/auth/SpnegoTokenGenerator;Z)V

    .line 58
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/auth/SpnegoTokenGenerator;Z)V
    .locals 0
    .param p1, "spengoGenerator"    # Lcom/comcast/cim/httpcomponentsandroid/impl/auth/SpnegoTokenGenerator;
    .param p2, "stripPort"    # Z

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateSchemeFactory;->spengoGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/auth/SpnegoTokenGenerator;

    .line 49
    iput-boolean p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateSchemeFactory;->stripPort:Z

    .line 50
    return-void
.end method


# virtual methods
.method public getSpengoGenerator()Lcom/comcast/cim/httpcomponentsandroid/impl/auth/SpnegoTokenGenerator;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateSchemeFactory;->spengoGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/auth/SpnegoTokenGenerator;

    return-object v0
.end method

.method public isStripPort()Z
    .locals 1

    .prologue
    .line 65
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateSchemeFactory;->stripPort:Z

    return v0
.end method

.method public newInstance(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    .locals 3
    .param p1, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 61
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateScheme;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateSchemeFactory;->spengoGenerator:Lcom/comcast/cim/httpcomponentsandroid/impl/auth/SpnegoTokenGenerator;

    iget-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateSchemeFactory;->stripPort:Z

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateScheme;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/auth/SpnegoTokenGenerator;Z)V

    return-object v0
.end method
