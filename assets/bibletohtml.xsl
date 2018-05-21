<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="This site is a transformed XML file
        with information about the Bible.">
      <title>Books of the Bible</title>
    </head>
    <body style="width:100%;">
      <h1>Books of the Bible</h1>
      <ol>
        <xsl:call-template name="book"/>
      </ol>
    </body>
  </html>
</xsl:template>

<xsl:template name="book">
  <xsl:value-of select="book"/>
  <xsl:for-each select="//book">
    <section>
      <h2><xsl:value-of select="@title"/></h2>
      <ol style="width:30em;">
        <xsl:call-template name="chapter"/>
      </ol>
    </section>
    <br style="clear:left;"/>
  </xsl:for-each>
</xsl:template>

<xsl:template name="chapter">
  <xsl:value-of select="chapter"/>
  <xsl:for-each select="//chapter">
    <xsl:if test="@read='yes'">
      <li style="float:left;width:3em;"><input type="checkbox" value="checked"/></li>
    </xsl:if>
    <li style="float:left;width:3em;"><input type="checkbox"/></li>
  </xsl:for-each>
</xsl:template>

</xsl:stylesheet>
