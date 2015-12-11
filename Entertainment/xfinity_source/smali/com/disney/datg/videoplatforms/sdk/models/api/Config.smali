.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Config;
.super Ljava/lang/Object;
.source "Config.java"

# interfaces
.implements Ljava/io/Serializable;
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/io/Serializable;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/models/api/Config;",
        ">;"
    }
.end annotation

.annotation runtime Lorg/simpleframework/xml/Root;
    name = "config"
    strict = false
.end annotation


# instance fields
.field private application:Lcom/disney/datg/videoplatforms/sdk/models/api/Application;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private features:Lcom/disney/datg/videoplatforms/sdk/models/api/Features;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private webservices:Lcom/disney/datg/videoplatforms/sdk/models/api/WebServices;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compareTo(Lcom/disney/datg/videoplatforms/sdk/models/api/Config;)I
    .locals 7
    .param p1, "newConfig"    # Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    .prologue
    .line 183
    new-instance v3, Lorg/simpleframework/xml/core/Persister;

    invoke-direct {v3}, Lorg/simpleframework/xml/core/Persister;-><init>()V

    .line 184
    .local v3, "serializer":Lorg/simpleframework/xml/Serializer;
    new-instance v2, Ljava/io/StringWriter;

    invoke-direct {v2}, Ljava/io/StringWriter;-><init>()V

    .line 185
    .local v2, "oldConfigWriter":Ljava/io/StringWriter;
    new-instance v1, Ljava/io/StringWriter;

    invoke-direct {v1}, Ljava/io/StringWriter;-><init>()V

    .line 187
    .local v1, "newConfigWriter":Ljava/io/StringWriter;
    :try_start_0
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getApplication()Lcom/disney/datg/videoplatforms/sdk/models/api/Application;

    move-result-object v4

    invoke-interface {v3, v4, v2}, Lorg/simpleframework/xml/Serializer;->write(Ljava/lang/Object;Ljava/io/Writer;)V

    .line 188
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getFeatures()Lcom/disney/datg/videoplatforms/sdk/models/api/Features;

    move-result-object v4

    invoke-interface {v3, v4, v2}, Lorg/simpleframework/xml/Serializer;->write(Ljava/lang/Object;Ljava/io/Writer;)V

    .line 189
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getWebservices()Lcom/disney/datg/videoplatforms/sdk/models/api/WebServices;

    move-result-object v4

    invoke-interface {v3, v4, v2}, Lorg/simpleframework/xml/Serializer;->write(Ljava/lang/Object;Ljava/io/Writer;)V

    .line 191
    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getApplication()Lcom/disney/datg/videoplatforms/sdk/models/api/Application;

    move-result-object v4

    invoke-interface {v3, v4, v1}, Lorg/simpleframework/xml/Serializer;->write(Ljava/lang/Object;Ljava/io/Writer;)V

    .line 192
    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getFeatures()Lcom/disney/datg/videoplatforms/sdk/models/api/Features;

    move-result-object v4

    invoke-interface {v3, v4, v1}, Lorg/simpleframework/xml/Serializer;->write(Ljava/lang/Object;Ljava/io/Writer;)V

    .line 193
    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getWebservices()Lcom/disney/datg/videoplatforms/sdk/models/api/WebServices;

    move-result-object v4

    invoke-interface {v3, v4, v1}, Lorg/simpleframework/xml/Serializer;->write(Ljava/lang/Object;Ljava/io/Writer;)V

    .line 195
    invoke-virtual {v2}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    .line 200
    :goto_0
    return v4

    .line 197
    :catch_0
    move-exception v0

    .line 198
    .local v0, "e":Ljava/lang/Exception;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 199
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "serializer.write exception "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 200
    const/4 v4, -0x1

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 17
    check-cast p1, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->compareTo(Lcom/disney/datg/videoplatforms/sdk/models/api/Config;)I

    move-result v0

    return v0
.end method

.method public getApplication()Lcom/disney/datg/videoplatforms/sdk/models/api/Application;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->application:Lcom/disney/datg/videoplatforms/sdk/models/api/Application;

    return-object v0
.end method

.method public getFeatureById(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;
    .locals 4
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 104
    invoke-static {p1}, Lcom/disney/datg/videoplatforms/sdk/utils/StringUtils;->isNotNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 105
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->features:Lcom/disney/datg/videoplatforms/sdk/models/api/Features;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->features:Lcom/disney/datg/videoplatforms/sdk/models/api/Features;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Features;->getFeatures()Ljava/util/ArrayList;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 106
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->features:Lcom/disney/datg/videoplatforms/sdk/models/api/Features;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Features;->getFeatures()Ljava/util/ArrayList;

    move-result-object v1

    .line 107
    .local v1, "features":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_2

    .line 108
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v2, v3, :cond_2

    .line 109
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;

    .line 110
    .local v0, "f":Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/disney/datg/videoplatforms/sdk/utils/StringUtils;->isNotNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 117
    .end local v0    # "f":Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;
    .end local v1    # "features":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;>;"
    .end local v2    # "i":I
    :cond_0
    :goto_1
    return-object v0

    .line 108
    .restart local v0    # "f":Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;
    .restart local v1    # "features":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;>;"
    .restart local v2    # "i":I
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 117
    .end local v0    # "f":Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;
    .end local v1    # "features":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;>;"
    .end local v2    # "i":I
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public getFeatures()Lcom/disney/datg/videoplatforms/sdk/models/api/Features;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->features:Lcom/disney/datg/videoplatforms/sdk/models/api/Features;

    return-object v0
.end method

.method public getParamInFeatureId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p1, "paramName"    # Ljava/lang/String;
    .param p2, "featureId"    # Ljava/lang/String;

    .prologue
    .line 121
    invoke-static {p1}, Lcom/disney/datg/videoplatforms/sdk/utils/StringUtils;->isNotNull(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-static {p2}, Lcom/disney/datg/videoplatforms/sdk/utils/StringUtils;->isNotNull(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 122
    invoke-virtual {p0, p2}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getFeatureById(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;

    move-result-object v0

    .line 123
    .local v0, "feature":Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;
    if-eqz v0, :cond_2

    .line 124
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;->getParam()Ljava/util/ArrayList;

    move-result-object v3

    .line 125
    .local v3, "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Param;>;"
    if-eqz v3, :cond_2

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_2

    .line 126
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v1, v4, :cond_2

    .line 127
    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/disney/datg/videoplatforms/sdk/models/api/Param;

    .line 128
    .local v2, "p":Lcom/disney/datg/videoplatforms/sdk/models/api/Param;
    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/Param;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/utils/StringUtils;->isNotNull(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/Param;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/Param;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 129
    :cond_0
    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/Param;->getAttrValue()Ljava/lang/String;

    move-result-object v4

    .line 135
    .end local v0    # "feature":Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;
    .end local v1    # "i":I
    .end local v2    # "p":Lcom/disney/datg/videoplatforms/sdk/models/api/Param;
    .end local v3    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Param;>;"
    :goto_1
    return-object v4

    .line 126
    .restart local v0    # "feature":Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;
    .restart local v1    # "i":I
    .restart local v2    # "p":Lcom/disney/datg/videoplatforms/sdk/models/api/Param;
    .restart local v3    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Param;>;"
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 135
    .end local v0    # "feature":Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;
    .end local v1    # "i":I
    .end local v2    # "p":Lcom/disney/datg/videoplatforms/sdk/models/api/Param;
    .end local v3    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Param;>;"
    :cond_2
    const/4 v4, 0x0

    goto :goto_1
.end method

.method public getURLFromWebServiceName(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 156
    invoke-static {p1}, Lcom/disney/datg/videoplatforms/sdk/utils/StringUtils;->isNotNull(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 157
    invoke-virtual {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getWebServiceByName(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;

    move-result-object v1

    .line 158
    .local v1, "ws":Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;
    if-eqz v1, :cond_1

    .line 159
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;->getNonsecure()Lcom/disney/datg/videoplatforms/sdk/models/api/NonSecure;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;->getNonsecure()Lcom/disney/datg/videoplatforms/sdk/models/api/NonSecure;

    move-result-object v2

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/NonSecure;->getUrl()Lcom/disney/datg/videoplatforms/sdk/models/api/Url;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 160
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;->getNonsecure()Lcom/disney/datg/videoplatforms/sdk/models/api/NonSecure;

    move-result-object v2

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/NonSecure;->getUrl()Lcom/disney/datg/videoplatforms/sdk/models/api/Url;

    move-result-object v0

    .line 161
    .local v0, "url":Lcom/disney/datg/videoplatforms/sdk/models/api/Url;
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Url;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/disney/datg/videoplatforms/sdk/utils/StringUtils;->isNotNull(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 162
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Url;->getValue()Ljava/lang/String;

    move-result-object v2

    .line 173
    .end local v0    # "url":Lcom/disney/datg/videoplatforms/sdk/models/api/Url;
    .end local v1    # "ws":Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;
    :goto_0
    return-object v2

    .line 164
    .restart local v1    # "ws":Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;
    :cond_0
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;->getSecure()Lcom/disney/datg/videoplatforms/sdk/models/api/Secure;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;->getSecure()Lcom/disney/datg/videoplatforms/sdk/models/api/Secure;

    move-result-object v2

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/Secure;->getUrl()Lcom/disney/datg/videoplatforms/sdk/models/api/Url;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 165
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;->getSecure()Lcom/disney/datg/videoplatforms/sdk/models/api/Secure;

    move-result-object v2

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/Secure;->getUrl()Lcom/disney/datg/videoplatforms/sdk/models/api/Url;

    move-result-object v0

    .line 166
    .restart local v0    # "url":Lcom/disney/datg/videoplatforms/sdk/models/api/Url;
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Url;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/disney/datg/videoplatforms/sdk/utils/StringUtils;->isNotNull(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 167
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Url;->getValue()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 173
    .end local v0    # "url":Lcom/disney/datg/videoplatforms/sdk/models/api/Url;
    .end local v1    # "ws":Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;
    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getWebServiceByName(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;
    .locals 4
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 139
    invoke-static {p1}, Lcom/disney/datg/videoplatforms/sdk/utils/StringUtils;->isNotNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->webservices:Lcom/disney/datg/videoplatforms/sdk/models/api/WebServices;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->webservices:Lcom/disney/datg/videoplatforms/sdk/models/api/WebServices;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/WebServices;->getWebServices()Ljava/util/ArrayList;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 140
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->webservices:Lcom/disney/datg/videoplatforms/sdk/models/api/WebServices;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/WebServices;->getWebServices()Ljava/util/ArrayList;

    move-result-object v2

    .line 141
    .local v2, "ws":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_1

    .line 142
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v0, v3, :cond_1

    .line 143
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;

    .line 144
    .local v1, "w":Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/disney/datg/videoplatforms/sdk/utils/StringUtils;->isNotNull(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 151
    .end local v0    # "i":I
    .end local v1    # "w":Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;
    .end local v2    # "ws":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;>;"
    :goto_1
    return-object v1

    .line 142
    .restart local v0    # "i":I
    .restart local v1    # "w":Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;
    .restart local v2    # "ws":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;>;"
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 151
    .end local v0    # "i":I
    .end local v1    # "w":Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;
    .end local v2    # "ws":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;>;"
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public getWebservices()Lcom/disney/datg/videoplatforms/sdk/models/api/WebServices;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->webservices:Lcom/disney/datg/videoplatforms/sdk/models/api/WebServices;

    return-object v0
.end method
