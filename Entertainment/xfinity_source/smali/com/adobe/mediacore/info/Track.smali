.class public abstract Lcom/adobe/mediacore/info/Track;
.super Ljava/lang/Object;


# instance fields
.field private final _isDefault:Z

.field private final _language:Ljava/lang/String;

.field private final _name:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/info/Track;->_name:Ljava/lang/String;

    iput-object p2, p0, Lcom/adobe/mediacore/info/Track;->_language:Ljava/lang/String;

    iput-boolean p3, p0, Lcom/adobe/mediacore/info/Track;->_isDefault:Z

    return-void
.end method


# virtual methods
.method public getLanguage()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/info/Track;->_language:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/info/Track;->_name:Ljava/lang/String;

    return-object v0
.end method

.method public isDefault()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/info/Track;->_isDefault:Z

    return v0
.end method
